package com.post.domain;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private long id;

    @NonNull @Getter @Setter
    private String name;
    @NonNull @Getter @Setter
    private String description;

    @Getter @Setter
    private boolean singlepage;

    @Getter @Setter
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<Question> questions;


}
