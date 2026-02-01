package br.com.curso.agendamento_clean_arch.infrastructure.presentation;

import br.com.curso.agendamento_clean_arch.core.entities.Schedule;
import br.com.curso.agendamento_clean_arch.core.usecase.contracts.*;
import br.com.curso.agendamento_clean_arch.infrastructure.dtos.ScheduleCreateRequest;
import br.com.curso.agendamento_clean_arch.infrastructure.dtos.ScheduleResponse;
import br.com.curso.agendamento_clean_arch.infrastructure.dtos.ScheduleUpdateRequest;
import br.com.curso.agendamento_clean_arch.infrastructure.mappers.ScheduleCreateMapper;
import br.com.curso.agendamento_clean_arch.infrastructure.mappers.ScheduleResponseMapper;
import br.com.curso.agendamento_clean_arch.infrastructure.mappers.ScheduleUpdateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1/schedules")
@RequiredArgsConstructor
public class ScheduleController {


    private final CreateScheduleUseCase createScheduleUseCase;
    private final FindScheduleByIdUseCase findScheduleByIdUseCase;
    private final CancelScheduleUseCase cancelScheduleUseCase;
    private final CompleteScheduleUseCase completeScheduleUseCase;
    private final UpdateScheduleUseCase updateScheduleUseCase;
    private final DeleteScheduleUseCase deleteScheduleUseCase;
    private final ScheduleResponseMapper scheduleResponseMapper;
    private final ScheduleUpdateMapper scheduleUpdateMapper;
    private final ScheduleCreateMapper scheduleCreateMapper;

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody ScheduleCreateRequest request){
        Schedule created = createScheduleUseCase.execute(scheduleCreateMapper.toEntity(request));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ", "Agendamento criado com sucesso!");
        response.put("Agendamento: ", scheduleResponseMapper.toDto(created));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(scheduleResponseMapper.toDto(findScheduleByIdUseCase.execute(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @RequestBody ScheduleUpdateRequest request){
        Schedule schedule = findScheduleByIdUseCase.execute(id);
        if(schedule == null) {
            return ResponseEntity.notFound().build();
        }
        Schedule updated = updateScheduleUseCase.execute(scheduleUpdateMapper.merge(schedule, request));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ", "Agendamento atualizado com sucesso!");
        response.put("Agendamento: ", scheduleResponseMapper.toDto(updated));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Map<String, Object>> cancel(@PathVariable Long id){
        Schedule schedule = findScheduleByIdUseCase.execute(id);
        if(schedule == null) {
            return ResponseEntity.notFound().build();
        }
        Schedule canceled = cancelScheduleUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem", "Agendamento cancelado com sucesso!");
        response.put("Agendamento: ", scheduleResponseMapper.toDto(canceled));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Map<String, Object>> complete(@PathVariable Long id){
        Schedule schedule = findScheduleByIdUseCase.execute(id);
        if(schedule == null) {
            return ResponseEntity.notFound().build();
        }
        Schedule completed = completeScheduleUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem", "Agendamento concluído com sucesso!");
        response.put("Agendamento: ", scheduleResponseMapper.toDto(completed));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id){
        Schedule schedule = findScheduleByIdUseCase.execute(id);
        if(schedule == null) {
            return ResponseEntity.notFound().build();
        }
        deleteScheduleUseCase.execute(id);
        Map<String, String> response = new HashMap<>();
        response.put("Mensagem", "Agendamento deletado com sucesso!");
        return ResponseEntity.ok(response);
    }
}
