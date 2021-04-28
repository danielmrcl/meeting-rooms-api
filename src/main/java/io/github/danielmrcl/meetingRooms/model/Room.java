package io.github.danielmrcl.meetingRooms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String name;
    @Column(name = "data", nullable = false)
    private String date;
    @Column(name = "hora_inicio", nullable = false)
    private String startHour;
    @Column(name = "hora_fim", nullable = false)
    private String endHour;
}
