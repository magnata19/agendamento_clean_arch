package br.com.curso.agendamento_clean_arch.infrastructure.mappers;

import br.com.curso.agendamento_clean_arch.core.entities.Schedule;
import br.com.curso.agendamento_clean_arch.core.enums.ScheduleStatus;
import br.com.curso.agendamento_clean_arch.infrastructure.persistence.model.ScheduleEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduleEntityMapper {

    public ScheduleEntity toEntity (Schedule schedule) {
        return ScheduleEntity.builder()
                .title(schedule.title())
                .description(schedule.description())
                .initialDate(schedule.initialDate())
                .finalDate(schedule.finalDate())
                .user(schedule.user())
                .status(ScheduleStatus.SCHEDULED)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public Schedule toDomain(ScheduleEntity entity) {
        return new Schedule(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getInitialDate(),
                entity.getFinalDate(),
                entity.getStatus(),
                entity.getUser(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
