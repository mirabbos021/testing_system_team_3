package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestHistory {
    private int userID;
    private int subjectId;
    private String time;
    private int quantityAnswers;
    private int quantituCorrectAnswers;
}
