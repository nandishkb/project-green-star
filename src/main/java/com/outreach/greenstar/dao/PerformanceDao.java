package com.outreach.greenstar.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.outreach.greenstar.entities.PerformanceParam;
import com.outreach.greenstar.repository.PerformanceRepository;

@Repository("performanceDao")
public class PerformanceDao {

    final static String FIND_BY_GROUP_QUERY = "SELECT P FROM PerformanceParam P WHERE P.group.id=:group.id AND P.DATE BETWEEN :fromDate AND :toDate";
    
    @Autowired
    private PerformanceRepository perfRepo;
    
//    @Autowired
//    private EntityManager entityManager;
//    
    
    /*public List<PerformanceParam> getPerformanceByGroup(Group group, Date fromDate,
        Date toDate) {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        criteriaBuilder.createQuery(PerformanceParam.class);
        TypedQuery<PerformanceParam> query = entityManager.createQuery(FIND_BY_GROUP_QUERY, PerformanceParam.class);
        List<PerformanceParam> listOfperf = query.getResultList();
        return listOfperf;
    }*/
    
    public List<PerformanceParam> getPerformanceByGroup(int groupId, Date fromDate,
        Date toDate) {
        List<PerformanceParam> listOfPerf = perfRepo.findbyGroupAndDateBetween(groupId, fromDate, toDate, Sort.by("student.rollNumber"));
        return  listOfPerf;
    }
    
    public List<PerformanceParam> getPerformanceByGroupSortByDate(int groupId, Date fromDate,
        Date toDate) {
        List<PerformanceParam> listOfPerf = perfRepo.findbyGroupAndDateBetween(groupId, fromDate, toDate, Sort.by("date"));
        return  listOfPerf;
    }

    public List<PerformanceParam> getPerformanceByStudentSortByDate(int studentId,
        Date fromDate, Date toDate) {
        List<PerformanceParam> listOfPerf = perfRepo.findByStudentAndDateBetween(studentId, fromDate, toDate, Sort.by("date"));
        return  listOfPerf;
    }

    public List<PerformanceParam> getPerformanceByClassSortBySectionName(int classId, Date from,
        Date to) {
        List<PerformanceParam> list = perfRepo.findByClsAndDateBetween(classId, from, to, Sort.by("section.name"));
        return list;
    }
    
    public List<PerformanceParam> getPerformanceByClassSortByGruopName(int classId, Date from,
        Date to) {
        List<PerformanceParam> list = perfRepo.findByClsAndDateBetween(classId, from, to, Sort.by("group.name"));
        return list;
    }
    
    public PerformanceParam getPerformanceByStudentAndByDate(int studentId, Date date) {
        return perfRepo.findOneByStudentAndDate(studentId, date);
    }

    @Transactional
    public void saveOrUpdate(PerformanceParam pParam) {
        perfRepo.saveAndFlush(pParam);
    }

}
