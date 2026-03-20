import collections

DIRECOES = ["NORTE", "LESTE", "SUL", "OESTE"]
MOVIMENTOS = {
    "NORTE": (0, 1),
    "LESTE": (1, 0),
    "SUL": (0, -1),
    "OESTE": (-1, 0),
}

pos_x = 0
pos_y = 0
direcao_idx_atual = 0  
mapa_visitado = {}

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

def recursivo():
    global pos_x, pos_y, direcao_idx_atual
    
    mapa_visitado[(pos_x, pos_y)] = True
    roberto.escreva(f"Explorando: ({pos_x}, {pos_y})")

    for _ in range(4):
        sensor_result = roberto.sensor()

        if sensor_result == "SAIDA":
            mover_roberto_e_atualizar_pos()
            return True

        dx, dy = MOVIMENTOS[DIRECOES[direcao_idx_atual]]
        proxima_pos = (pos_x + dx, pos_y + dy)

        if sensor_result == "LIVRE" and proxima_pos not in mapa_visitado:
            x_antes, y_antes = pos_x, pos_y
            
            mover_roberto_e_atualizar_pos()
            
            if recursivo():
                return True
            
            roberto.escreva(f"Voltando para ({x_antes}, {y_antes})")
            virar_direita_roberto_e_atualizar_dir()
            virar_direita_roberto_e_atualizar_dir()
            mover_roberto_e_atualizar_pos()
            virar_direita_roberto_e_atualizar_dir()
            virar_direita_roberto_e_atualizar_dir()

        virar_direita_roberto_e_atualizar_dir()

    return False

def main():
    global pos_x, pos_y, direcao_idx_atual, mapa_visitado
    roberto.escreva("Recursivo Iniciado.")
    pos_x, pos_y, direcao_idx_atual = 0, 0, 0
    mapa_visitado = {}

    if recursivo():
        roberto.escreva("Missão Cumprida.")
    else:
        roberto.escreva("Caminho não encontrado.")

main()
