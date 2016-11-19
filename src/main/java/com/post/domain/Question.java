package com.post.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private long id;

    @NonNull @Getter @Setter
    private String question;
//    @NonNull @Getter @Setter @Transient
//    private List<String> answersText;

    @Getter @Setter @NonNull
    @ManyToOne()
    @JoinColumn()
    private Test test;

    @Getter @Setter
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;

    @NonNull @Getter @Setter
    private boolean checkbox;
}
