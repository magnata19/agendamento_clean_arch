package br.com.curso.agendamento_clean_arch.infrastructure.gateways;

import br.com.curso.agendamento_clean_arch.core.entities.Schedule;
import br.com.curso.agendamento_clean_arch.core.enums.ScheduleStatus;
import br.com.curso.agendamento_clean_arch.core.gateway.ScheduleGateway;
import br.com.curso.agendamento_clean_arch.infrastructure.mappers.ScheduleEntityMapper;
import br.com.curso.agendamento_clean_arch.infrastructure.persistence.model.ScheduleEntity;
import br.com.curso.agendamento_clean_arch.infrastructure.persistence.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ScheduleRepositoryGateway implements ScheduleGateway {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleEntityMapper entityMapper;

    @Override
    public Schedule create(Schedule schedule) {
        ScheduleEntity scheduleSaved = scheduleRepository.save(entityMapper.toEntity(schedule));
        return entityMapper.toDomain(scheduleSaved);
    }

    @Override
    public Schedule findScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .map(entityMapper::toDomain).orElse(null);
    }

    @Override
    public Schedule update(Schedule schedule) {
        return entityMapper.toDomain(scheduleRepository.save(entityMapper.toEntity(schedule)));
    }

    @Override
    public Schedule cancelSchedule(Long id) {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado."));
        scheduleEntity.setStatus(ScheduleStatus.CANCELED);
        scheduleEntity.setUpdatedAt(LocalDateTime.now());
        return entityMapper.toDomain(scheduleRepository.save(scheduleEntity));
    }

    @Override
    public Schedule completeSchedule(Long id) {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado."));
        scheduleEntity.setStatus(ScheduleStatus.COMPLETED);
        scheduleEntity.setUpdatedAt(LocalDateTime.now());
        return entityMapper.toDomain(scheduleRepository.save(scheduleEntity));
    }

    @Override
    public void delete(Long id) {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado."));
        scheduleRepository.delete(scheduleEntity);
    }
}
