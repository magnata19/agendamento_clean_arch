package br.com.curso.agendamento_clean_arch.core.gateway;

import br.com.curso.agendamento_clean_arch.core.entities.Schedule;

public interface ScheduleGateway {
    Schedule create(Schedule schedule);
    Schedule findScheduleById(Long id);
    Schedule update(Schedule schedule);
    Schedule cancelSchedule(Long id);
    Schedule completeSchedule(Long id);
    void delete(Long id);
}
