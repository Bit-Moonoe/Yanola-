package com.yanola.yanolatetris.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "GROUPS")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Group {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "GROUP_ID")
    private String groupId;

    @Column
    private String groupMileage;

    @Column
    private String groupScore;

    @Column
    private String gameItem;

    @ToString
    @Builder
    @Getter
    @Setter
    public static class Request {

        private String groupId;

        private String groupMileage;

        private String groupScore;

        private String gameItem;

        public static Group toEntity(final Request request) {
            return Group.builder().groupId(request.getGroupId())
                    .groupMileage(request.getGroupMileage())
                    .groupScore(request.getGroupScore())
                    .gameItem(request.getGameItem())
                    .build();
        }
    }

    @ToString
    @Builder
    @Getter
    @Setter
    public static class Response {
        private String groupId;

        private String groupMileage;

        private String groupScore;

        private String gameItem;

        private String token;

        public static Group.Response toResponse(final Group group) {

            return Response.builder().groupId(group.getGroupId())
                    .groupMileage(group.getGroupMileage())
                    .groupScore(group.getGroupScore())
                    .gameItem(group.getGameItem())
                    .build();
        }

        public static List<Group.Response> toResponseList(final List<Group> group) {
            List<Group.Response> groupList = new ArrayList<>();
            for (Group groupAdd : group) {
                groupList.add(toResponse(groupAdd));
            }
            return groupList;

        }
    }

}