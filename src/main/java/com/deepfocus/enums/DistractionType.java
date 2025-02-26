package com.deepfocus.enums;

public enum DistractionType {
  TROCA_ABA,       // Usuário mudou de aba/janela durante a sessão
  EXPRESSAO_FACIAL, // Expressão facial indicou distração (ex: olhando para o lado)
  INATIVIDADE,     // Sem interações por um tempo prolongado
  NOTIFICACAO,     // Notificação de outro aplicativo interrompeu o usuário
  OUTRO            // Para outros tipos de distração que possam surgir
}