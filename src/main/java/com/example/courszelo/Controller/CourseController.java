package com.example.courszelo.Controller;

import com.example.courszelo.Repository.CourseRepository;
import com.example.courszelo.Service.CourseService;
import com.example.courszelo.entity.Courses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/courses")
public class CourseController {
    private final CourseService courseService;
    private final CourseRepository courseRepository;
    @GetMapping
    public List<Courses> getAllCourses() {
        return courseService.getAllCourses();
    }
    @GetMapping("/average-rating/{company}")
    public double getAverageRatingByCompany(@PathVariable String company) {
        return courseService.getAverageRatingByCompany(company);
    }

    @GetMapping("/average-rating-by-company")
    public Map<String, Double> getAverageRatingByCompany() {
        return courseService.getAverageRatingAllByCompany();
    }

    @GetMapping("/average-courses-by-company")
    public Map<String, Double> getAverageCoursesByCompany() {
        return courseService.getAverageCoursesByCompany();
    }

    @GetMapping("/courses-count/{company}")
    public long getCoursesCountByCompany(@PathVariable String company) {
        return courseService.getCoursesCountByCompany(company);
    }

    @GetMapping("/top5")
    public List<Courses> getTop5RatedCourses() {
        return courseService.getTop5RatedCourses();
    }

    @GetMapping("/last5")
    public List<Courses> getLast5RatedCourses() {
        return courseService.getLast5RatedCourses();
    }


//    @GetMapping("/keywords")
//    public Map<String, Integer> getCourseKeyw< ords() {
//        // Analyser les noms de cours et obtenir les mots-clés avec leur fréquence
//        return courseService.analyzeCourseNames(Courses.);
//    }

    @PostMapping("/api/courses/analyze")
    public ResponseEntity<Map<String, Integer>> analyzeCourseNames(@RequestBody String[] courseNames) {
        Map<String, Integer> wordFrequencyMap = courseService.analyzeCourseNames(courseNames);
        return ResponseEntity.ok(wordFrequencyMap);
    }





    }


