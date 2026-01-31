package br.com.curso.agendamento_clean_arch.infrastructure.persistence.model;

import br.com.curso.agendamento_clean_arch.core.enums.ScheduleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_schedules")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "initial_date", nullable = false)
    private LocalDateTime initialDate;

    @Column(nullable = false, length = 20, name = "final_date")
    private LocalDateTime finalDate;

    @Enumerated(EnumType.STRING)
    private ScheduleStatus status;

    @Column(nullable = false, length = 80)
    private String user;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;
}
