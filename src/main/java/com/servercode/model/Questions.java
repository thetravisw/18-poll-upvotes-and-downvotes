package com.servercode.model;

import javax.persistence.*;

@Entity
@Table(name="Questions")
public class Questions implements Comparable<Questions>{
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 2244
    )
    public long id;
    public String question;
    public int votes;
    public int downvotes;

    // requires default constructor
    public Questions(){}

    public Questions(String question) {
        this.question = question;
        this.votes = 0;
        this.downvotes = 0;
    }

    @Override
    // return -1 if this is less than the other one
    // return  0 if these two things are equal
    // return  1 if this is greater than the other one
    public int compareTo(Questions o) {
        return (o.votes-o.downvotes) - (this.votes - this.downvotes);
    }
}
