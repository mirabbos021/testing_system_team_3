package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question {
    private int id;
    private int subjectId;
    private String text;
    private String correctAnswer;
    private String variants;
    protected LocalDate date = LocalDate.now();
}
