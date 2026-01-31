package br.com.curso.agendamento_clean_arch.infrastructure.mappers;

import br.com.curso.agendamento_clean_arch.core.entities.Schedule;
import br.com.curso.agendamento_clean_arch.core.enums.ScheduleStatus;
import br.com.curso.agendamento_clean_arch.infrastructure.dtos.ScheduleUpdateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduleUpdateMapper {

    public ScheduleUpdateRequest toDto(Schedule schedule){
        return new ScheduleUpdateRequest(
                schedule.title(),
                schedule.description(),
                schedule.initialDate(),
                schedule.finalDate()
        );
    }

    public Schedule merge(Schedule existingSchedule, ScheduleUpdateRequest req){
        return new Schedule(
                existingSchedule.id(),
                req.title() != null ? req.title() : existingSchedule.title(),
                req.description() != null ? req.description() : existingSchedule.description(),
                req.initialDate() != null ? req.initialDate() : existingSchedule.initialDate(),
                req.finalDate() != null ? req.finalDate() : existingSchedule.finalDate(),
                existingSchedule.status(),
                existingSchedule.user(),
                existingSchedule.createdAt(),
                LocalDateTime.now()
        );
    }

    public Schedule toEntity (ScheduleUpdateRequest schedule){
        return new Schedule(
                null,
                schedule.title(),
                schedule.description(),
                schedule.initialDate(),
                schedule.finalDate(),
                ScheduleStatus.SCHEDULED,
                null,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

}
