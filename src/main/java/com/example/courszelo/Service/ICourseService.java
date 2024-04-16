package com.example.courszelo.Service;

import com.example.courszelo.entity.Courses;

import java.util.List;
import java.util.Map;

public interface ICourseService {
    public double getAverageRatingByCompany(String company);
    public Map<String, Double> getAverageRatingAllByCompany();
    public Map<String, Double> getAverageCoursesByCompany();
    public long getCoursesCountByCompany(String company);
    public List<Courses> getTop5RatedCourses();
    public List<Courses> getLast5RatedCourses();

    public Map<String, Integer> analyzeCourseNames(String[] courseNames);
}
