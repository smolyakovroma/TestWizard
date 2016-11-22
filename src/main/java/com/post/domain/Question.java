package com.post.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@ToString
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

    @NonNull @Getter @Setter
    private int index;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (id != question.id) return false;
        return !(test != null ? !test.equals(question.test) : question.test != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (test != null ? test.hashCode() : 0);
        return result;
    }
}
