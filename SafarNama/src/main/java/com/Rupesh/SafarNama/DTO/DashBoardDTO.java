package com.Rupesh.SafarNama.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class DashBoardDTO {

    private Long upcomingEvents;

    public Long getCompletedEvents() {
        return completedEvents;
    }

    public void setCompletedEvents(Long completedEvents) {
        this.completedEvents = completedEvents;
    }

    public Long getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(Long upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    public Long getUpcomingTrek() {
        return upcomingTrek;
    }

    public void setUpcomingTrek(Long upcomingTrek) {
        this.upcomingTrek = upcomingTrek;
    }

    public Long getEnquiries() {
        return enquiries;
    }

    public void setEnquiries(Long enquiries) {
        this.enquiries = enquiries;
    }

    private Long completedEvents;
    private Long upcomingTrek;
    private Long enquiries;
}
