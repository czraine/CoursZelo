package com.example.courszelo.Service;

import com.example.courszelo.Repository.CourseRepository;
import com.example.courszelo.entity.Courses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import opennlp.tools.tokenize.SimpleTokenizer;


@Service
@AllArgsConstructor
public class CourseService implements ICourseService {
    private final CourseRepository courseRepository;
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    private final MongoTemplate mongoTemplate;

    public double getAverageRatingByCompany(String company) {
        List<Courses> courses = mongoTemplate.find(Query.query(where("COMPANY").is(company)), Courses.class);
        double sum = 0;
        for (Courses course : courses) {
            sum += course.getRATTINGS();
        }
        return sum / courses.size();
    }

    public Map<String, Double> getAverageRatingAllByCompany() {
        List<Courses> courses = mongoTemplate.findAll(Courses.class);

        // Regroupement des cours par entreprise
        Map<String, List<Courses>> coursesByCompany = courses.stream()
                .collect(Collectors.groupingBy(Courses::getCOMPANY));

        // Calcul de la moyenne des notes pour chaque entreprise
        Map<String, Double> averageRatingByCompany = coursesByCompany.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToDouble(Courses::getRATTINGS)
                                .average()
                                .orElse(0.0)));

        return averageRatingByCompany;
    }

    public Map<String, Double> getAverageCoursesByCompany() {
        List<Courses> courses = mongoTemplate.findAll(Courses.class);

        // Regroupement des cours par entreprise
        Map<String, List<Courses>> coursesByCompany = courses.stream()
                .collect(Collectors.groupingBy(Courses::getCOMPANY));

        // Calcul du nombre de cours pour chaque entreprise
        Map<String, Double> averageCoursesByCompany = coursesByCompany.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (double) entry.getValue().size()));

        return averageCoursesByCompany;
    }

    public long getCoursesCountByCompany(String company) {
        Query query = new Query();
        query.addCriteria(Criteria.where("COMPANY").is(company));
        return mongoTemplate.count(query, Courses.class);
    }

    public List<Courses> getTop5RatedCourses() {
        Query query = new Query().with(Sort.by(Sort.Direction.DESC, "RATTINGS")).limit(5);
        return mongoTemplate.find(query, Courses.class);
    }

    public List<Courses> getLast5RatedCourses() {
        Query query = new Query().with(Sort.by(Sort.Direction.ASC, "RATTINGS")).limit(5);
        return mongoTemplate.find(query, Courses.class);
    }

    public Map<String, Integer> analyzeCourseNames(String[] courseNames) {
        Map<String, Integer> wordFreqMap = new HashMap<>();

        for (String courseName : courseNames) {
            // Tokenize using split and a regular expression to match spaces,
            // assuming tokens are separated by spaces.
            String[] tokens = courseName.toLowerCase().split("\\s+");

            for (String token : tokens) {
                // Filter out non-alphabetic tokens. The token.matches call ensures
                // that the token consists solely of alphabetic characters.
                if (token.matches("[a-zA-Z]+")) {
                    wordFreqMap.put(token, wordFreqMap.getOrDefault(token, 0) + 1);
                }
            }
        }

        return wordFreqMap;
    }


}

