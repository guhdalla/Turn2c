package com.turn2c.domain.enums;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessageEnum {

    INTERNAL_SERVER_ERROR("1", "Erro Interno do Servidor", "Infelizmente ocorreu um erro interno no servidor. Tente novamente mais tarde."),
    MESSAGE_NOT_READABLE("2", "Mensagem não legível", "A mensagem enviada não é legível. Verifique se o formato está correto."),
    ARGUMENT_NOT_VALID("3", "Argumento não válido", "O argumento enviado não é válido. Verifique se o formato está correto."),
    ACCESS_DENIED("4", "Acesso negado", "Você não tem permissão para acessar este recurso."),
    NOT_FOUND("5", "Não encontrado", "O recurso solicitado não foi encontrado."),
    ;

    private final String code;
    private final String message;
    private final String description;

    public static ErrorMessageEnum getErrorMessageEnum(String code) {

        return Arrays.stream(ErrorMessageEnum.values()).filter(e -> e.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(INTERNAL_SERVER_ERROR);
    }
}
