package com.turn2c.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.turn2c.domain.enums.ErrorMessageEnum;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<C> {

    private C data;
    private ErrorResponseDto error;
    private String timestamp;
    private String traceId;

    public static <C> ResponseDto<C> success() {
        return ResponseDto.<C>builder()
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .build();
    }

    public static <C> ResponseDto<C> success(C data) {
        return ResponseDto.<C>builder()
                .data(data)
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .build();
    }

    public static <E extends Exception> ResponseDto<Void> error(ErrorMessageEnum error, E e) {
        return ResponseDto.<Void>builder()
                .error(ErrorResponseDto.builder()
                        .code(error.getCode())
                        .message(error.getMessage())
                        .description(error.getDescription())
                        .trace(e.getMessage())
                        .build())
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .build();
    }

    public static <E extends MethodArgumentNotValidException> ResponseDto<Void> error(ErrorMessageEnum error, E e) {

        List<ValidationFailureDto> details = e.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> ValidationFailureDto.builder()
                        .field(fieldError.getField())
                        .message(fieldError.getDefaultMessage())
                        .build())
                .toList();

        return ResponseDto.<Void>builder()
                .error(ErrorResponseDto.builder()
                        .code(error.getCode())
                        .message(error.getMessage())
                        .description(error.getDescription())
                        .trace(e.getMessage())
                        .details(details)
                        .build())
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .build();
    }
}
