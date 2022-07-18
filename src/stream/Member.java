package stream;

import java.time.LocalDateTime;

class Member {

    private Long id;
    private String name;
    private LocalDateTime signUpDate;

    public Member(Long id, String name, LocalDateTime signUpDate) {
        this.id = id;
        this.name = name;
        this.signUpDate = signUpDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(LocalDateTime signUpDate) {
        this.signUpDate = signUpDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", signUpDate=" + signUpDate +
                '}';
    }
}
