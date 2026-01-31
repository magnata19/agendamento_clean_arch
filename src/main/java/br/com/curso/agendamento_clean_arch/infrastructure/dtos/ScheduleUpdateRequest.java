package br.com.curso.agendamento_clean_arch.infrastructure.dtos;

import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record ScheduleUpdateRequest(
        @Size(max = 120)
        String title,

        @Size(max = 4000)
        String description,
        LocalDateTime initialDate,
        LocalDateTime finalDate
) {
}
