package com.post.domain;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (id != test.id) return false;
        return !(name != null ? !name.equals(test.name) : test.name != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
