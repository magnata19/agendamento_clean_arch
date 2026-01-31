package br.com.curso.agendamento_clean_arch.infrastructure.dtos;

import br.com.curso.agendamento_clean_arch.core.enums.ScheduleStatus;

import java.time.LocalDateTime;

public record ScheduleResponse(
        Long id,
        String title,
        String description,
        LocalDateTime initialDate,
        LocalDateTime finalDate,
        ScheduleStatus status,
        String user,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
