package com.post.domain;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private long id;
    @NonNull
    @Getter @Setter
    private String answer;
    @Getter @Setter @NonNull
    @ManyToOne()
    @JoinColumn()
    private Question question;


}
