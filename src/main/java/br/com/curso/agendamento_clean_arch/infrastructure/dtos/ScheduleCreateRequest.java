package br.com.curso.agendamento_clean_arch.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record ScheduleCreateRequest(
        @NotBlank
        @Size(max = 120)
        String title,

        @Size(max = 4000)
        String description,

        @NotNull
        LocalDateTime initialDate,

        @NotNull
        LocalDateTime finalDate,

        @NotBlank
        @Size(max = 80)
        String user
) {
}
