package com.tonyadjei.springbootbasics.Exercise6;


import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Task {
    private String title;
    private int id;
    private static int nextIDCount = 0;

    {
        nextIDCount += 1;
    }

    public Task(String title) {
        this.title = title;
        this.id = nextIDCount;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class TaskRequest {
        private String title;
    }


}
