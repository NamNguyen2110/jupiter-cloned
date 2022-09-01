package com.jupiter.oppsservice.repository.impl;

import com.jupiter.oppsservice.domain.dto.request.OppProcessRequest;
import com.jupiter.oppsservice.domain.dto.response.OppProcessResponse;
import com.jupiter.oppsservice.repository.OppProcessRepository;
import org.springframework.stereotype.Repository;
import com.jupiter.common.utils.DataUtils;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OppProcessRepositoryImpl implements OppProcessRepository {
    @PersistenceContext
    EntityManager em;
    @Override
    public List<OppProcessResponse> getOppProcessResult(OppProcessRequest oppProcessRequest) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT status,COUNT(status) as quantity ");
        sql.append("FROM opp_application oa ");
        sql.append("WHERE oa.opp_id = :oppId AND oa.opp_position_id = :oppPositionId AND oa.process_type = :processType ");
        sql.append("GROUP BY oa.process_type,oa.opp_id,oa.opp_position_id,oa.status");

        StringBuilder sql1 = new StringBuilder();
        sql1.append("SELECT COUNT(employee_id) ");
        sql1.append("FROM opp_application oa ");
        sql1.append("WHERE oa.opp_id = :oppId AND oa.opp_position_id = :oppPositionId");

        Query query1 = em.createNativeQuery(sql1.toString());
        query1.setParameter("oppId", oppProcessRequest.getOppId());
        query1.setParameter("oppPositionId", oppProcessRequest.getOppPositionId());
        List<OppProcessResponse> data1 = new ArrayList<>();
        int amountOfEmployee = Integer.parseInt(query1.getSingleResult().toString());

        Query query = em.createNativeQuery(sql.toString());
        query.setParameter("oppId", oppProcessRequest.getOppId());
        query.setParameter("oppPositionId", oppProcessRequest.getOppPositionId());
        query.setParameter("processType", oppProcessRequest.getProcessType());
        List<OppProcessResponse> data = new ArrayList<>();
        List<Object[]> objects = query.getResultList();

        objects.forEach(row -> {
            OppProcessResponse oppProcessResponse = new OppProcessResponse();
            oppProcessResponse.setOppId(oppProcessRequest.getOppId());
            oppProcessResponse.setOppPositionId(oppProcessRequest.getOppPositionId());
            oppProcessResponse.setProcessType(oppProcessRequest.getProcessType());
            oppProcessResponse.setStatus(DataUtils.safeToString(row[0]));
            oppProcessResponse.setQuantityStatus(DataUtils.safeToInteger(row[1]));
            oppProcessResponse.setSubmittedAmount(amountOfEmployee);
            data.add(oppProcessResponse);
        });

        return data;
    }

}
