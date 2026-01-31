package br.com.curso.agendamento_clean_arch.infrastructure.mappers;

import br.com.curso.agendamento_clean_arch.core.entities.Schedule;
import br.com.curso.agendamento_clean_arch.core.enums.ScheduleStatus;
import br.com.curso.agendamento_clean_arch.infrastructure.dtos.ScheduleCreateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduleCreateMapper {

    public ScheduleCreateRequest toDto(Schedule schedule) {
        return new ScheduleCreateRequest(
                schedule.title(),
                schedule.description(),
                schedule.initialDate(),
                schedule.finalDate(),
                schedule.user()
        );
    }

    public Schedule toEntity(ScheduleCreateRequest dto) {
        return new Schedule(
                null,
                dto.title(),
                dto.description(),
                dto.initialDate(),
                dto.finalDate(),
                ScheduleStatus.SCHEDULED,
                dto.user(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
