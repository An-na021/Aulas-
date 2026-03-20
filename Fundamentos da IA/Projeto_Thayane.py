import collections

def resolver_recursivo():
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
            x_antigo, y_antigo = pos_x, pos_y
            
            mover_roberto_e_atualizar_pos()
            
            if resolver_recursivo():
                return True 
            

            roberto.escreva(f"Beco sem saída em {proxima_pos}. Voltando para ({x_antigo}, {y_antigo})")
            
            virar_direita_roberto_e_atualizar_dir()
            virar_direita_roberto_e_atualizar_dir()
            mover_roberto_e_atualizar_pos()
            virar_direita_roberto_e_atualizar_dir()
            virar_direita_roberto_e_atualizar_dir()

        virar_direita_roberto_e_atualizar_dir()

    return False 

def main():
    global pos_x, pos_y, direcao_idx_atual, mapa_visitado
    roberto.escreva("Iniciando Firmware Recursivo")
    
    pos_x, pos_y, direcao_idx_atual = 0, 0, 0
    mapa_visitado = {}

    if resolver_recursivo():
        roberto.escreva("Missão cumprida! Saída encontrada.")
    else:
        roberto.escreva("Labirinto sem saída.")

main()
