import collections

# Define as direções e giros
DIRECOES = ["NORTE", "LESTE", "SUL", "OESTE"]

# Mapeamento de movimentos para coordenadas relativas
# (dx, dy) para (Norte, Leste, Sul, Oeste)
MOVIMENTOS = {
    "NORTE": (0, 1),
    "LESTE": (1, 0),
    "SUL": (0, -1),
    "OESTE": (-1, 0),
}

# Variáveis globais para o estado do robô
pos_x = 0
pos_y = 0
direcao_idx_atual = 0  # 0: NORTE, 1: LESTE, 2: SUL, 3: OESTE

# Mapa para armazenar o que o robô já viu
# Chave: (x, y), Valor: True (visitado) ou False (não visitado)
mapa_visitado = {}

# Pilha para o DFS (para backtracking lógico)
# Armazena tuplas (x, y, direcao_idx) dos pontos de decisão
pilha_caminho = []

def mover_roberto_e_atualizar_pos():
    global pos_x, pos_y
    dx, dy = MOVIMENTOS[DIRECOES[direcao_idx_atual]]
    pos_x += dx
    pos_y += dy
    roberto.mover()  

def virar_direita_roberto_e_atualizar_dir():
    global direcao_idx_atual
    direcao_idx_atual = (direcao_idx_atual + 1) % 4
    roberto.virar_direita()

def virar_esquerda_roberto_e_atualizar_dir():
    global direcao_idx_atual
    direcao_idx_atual = (direcao_idx_atual - 1 + 4) % 4
    roberto.virar_esquerda()

def main():
    global pos_x, pos_y, direcao_idx_atual, mapa_visitado, pilha_caminho
    roberto.escreva("Iniciando firmware do R.O.B.E.R.T.O. (DFS com exploração)")

    pos_x = 0
    pos_y = 0
    direcao_idx_atual = 0  # Começa virado para o Norte
    mapa_visitado = {}
    pilha_caminho = []

    # O robô sempre começa em (0,0)
    mapa_visitado[(pos_x, pos_y)] = True

    while True:
        roberto.escreva(f"Posição atual: ({pos_x}, {pos_y}), Direção: {DIRECOES[direcao_idx_atual]}")

        sensor_result = roberto.sensor()

        if sensor_result == "SAIDA":
            roberto.escreva("SAIDA ENCONTRADA! Movendo para a saída.")
            mover_roberto_e_atualizar_pos()
            roberto.escreva("Missão cumprida!")
            break

        # Tentar mover para frente se for LIVRE e a próxima célula não foi visitada
        dx, dy = MOVIMENTOS[DIRECOES[direcao_idx_atual]]
        proxima_x, proxima_y = pos_x + dx, pos_y + dy

        if sensor_result == "LIVRE" and (proxima_x, proxima_y) not in mapa_visitado:
            roberto.escreva(f"Caminho livre para ({proxima_x}, {proxima_y}). Avançando.")
            pilha_caminho.append((pos_x, pos_y, direcao_idx_atual)) # Salva o ponto de decisão
            mover_roberto_e_atualizar_pos()
            mapa_visitado[(pos_x, pos_y)] = True # Marca a nova posição como visitada
            continue # Continua a exploração a partir da nova posição

        # Se não pode ir para frente, tenta virar e explorar outras direções
        # Tenta todas as 4 direções a partir da posição atual
        encontrou_caminho_valido = False
        for _ in range(4): 
            # Gira para a próxima direção
            virar_direita_roberto_e_atualizar_dir()
            roberto.escreva(f"Virando à direita para {DIRECOES[direcao_idx_atual]}")

            sensor_result_loop = roberto.sensor()
            dx_loop, dy_loop = MOVIMENTOS[DIRECOES[direcao_idx_atual]]
            proxima_x_loop, proxima_y_loop = pos_x + dx_loop, pos_y + dy_loop

            if sensor_result_loop == "SAIDA":
                roberto.escreva("SAIDA ENCONTRADA! Movendo para a saída.")
                mover_roberto_e_atualizar_pos()
                roberto.escreva("Missão cumprida!")
                return # Termina a função main

            if sensor_result_loop == "LIVRE" and (proxima_x_loop, proxima_y_loop) not in mapa_visitado:
                roberto.escreva(f"Caminho livre para ({proxima_x_loop}, {proxima_y_loop}). Avançando.")
                pilha_caminho.append((pos_x, pos_y, direcao_idx_atual)) # Salva o ponto de decisão
                mover_roberto_e_atualizar_pos()
                mapa_visitado[(pos_x, pos_y)] = True
                encontrou_caminho_valido = True
                break # Sai do loop de 4 direções e continua a exploração
        
        if encontrou_caminho_valido:
            continue # Continua a exploração a partir da nova posição

        # Se chegou aqui, significa que não há caminho livre e não visitado a partir da posição atual.
        # É um beco sem saída ou todas as direções levam a células já visitadas.
        roberto.escreva("Beco sem saída ou todas as direções exploradas. Fazendo backtracking.")

        if not pilha_caminho:
            roberto.escreva("Não há mais pontos de decisão para backtracking. Labirinto insolúvel ou erro.")
            break # Não há mais para onde voltar

        # Backtracking físico: reverter para o último ponto de decisão
        prev_x, prev_y, prev_dir_idx = pilha_caminho.pop()
        roberto.escreva(f"Voltando para ({prev_x}, {prev_y}) na direção {DIRECOES[prev_dir_idx]}")

        # Para voltar ao estado anterior, o robô precisa se orientar e mover.
        # Primeiro, girar para a direção oposta à que ele veio.
        # A direção atual é a que ele estava antes de entrar no beco sem saída.
        # Ele precisa girar 180 graus para "olhar para trás".
        virar_direita_roberto_e_atualizar_dir()
        virar_direita_roberto_e_atualizar_dir()
        mover_roberto_e_atualizar_pos()
        
        # Agora o robô está na posição anterior, mas virado para a direção oposta
        # à que ele veio. Ele precisa girar para a direção que ele estava
        # quando *saiu* daquela posição para explorar o próximo caminho.
        # Ou seja, ele precisa estar na `prev_dir_idx`.
        
        # Ajustar a direção para a direção do ponto de decisão anterior
        # Calcular a diferença de direção
        diff_dir = (prev_dir_idx - direcao_idx_atual + 4) % 4
        if diff_dir == 1: # Precisa virar à direita
            virar_direita_roberto_e_atualizar_dir()
        elif diff_dir == 2: # Precisa virar 180 graus
            virar_direita_roberto_e_atualizar_dir()
            virar_direita_roberto_e_atualizar_dir()
        elif diff_dir == 3: # Precisa virar à esquerda
            virar_esquerda_roberto_e_atualizar_dir()
        
        pos_x = prev_x
        pos_y = prev_y
        direcao_idx_atual = prev_dir_idx

    roberto.escreva("DFS: Nenhum caminho encontrado para a saída.")

# Chamar a função main para executar o algoritmo DFS
main()