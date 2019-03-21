package com.outreach.greenstar.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.outreach.greenstar.entities.PerformanceParam;
import com.outreach.greenstar.entities.Cls;

public interface PerformanceRepository
    extends JpaRepository<PerformanceParam, Number> {

//    final static String FIND_BY_GROUP_QUERY = "SELECT P "
//        + "FROM PerformanceParam P WHERE P.group.id=:group.id AND P.DATE BETWEEN :from AND :to";
//
//    @Query(FIND_BY_GROUP_QUERY)
//    @Query("select p from PerformanceParam p where p.group.id=$1 and p.date between ")
//    List<PerformanceParam> findByGroup(int id, Date from, Date to, Sort sort);

//    List<PerformanceParam> findByGroup(Group group);

//    @Query("select p from PerformanceParam p where p.group.id=$1 and p.date between $2 & $3")
//    public List<PerformanceParam> findByDateBetweenAndGroup(int id, Date from, Date to, Sort sort);
    
//    @Query("select p from PerformanceParam p where p.group.id=$1 and p.date between $2 and $3")
    @Query("select p from PerformanceParam p where p.group.id=:id and p.date between :from and :to")
    public List<PerformanceParam> findbyGroupAndDateBetween(int id, Date from, Date to, Sort sort);
    
    @Query("select p from PerformanceParam p where p.student.id=:id and p.date between :from and :to")
    public List<PerformanceParam> findByStudentAndDateBetween(int id, Date from, Date to, Sort sort);
    
    @Query("select p from PerformanceParam p where p.cls.id=:id and p.date between :from and :to")
    List<PerformanceParam> findByClsAndDateBetween(int id, Date from, Date to, Sort sort);
    
}
