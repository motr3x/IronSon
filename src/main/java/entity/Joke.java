package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Joke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="text")
    private String text;
    @Column(name="date_of_create")
    private Date dateOfCreate;
    @Column(name="date_of_modify")
    private Date dateOfModify;
}
