/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.occ.ingenieria.tpi135.bachestpi.control;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.ues.occ.ingenieria.tpi135.bachestpi.entity.ObjetoEstado;

/**
 *
 * @author armandop444
 */
@Stateless
@LocalBean
public class ObjetoEstadoBean extends abstractDataAccess<ObjetoEstado> implements Serializable {

    @PersistenceContext(unitName = "BACHES-PU")
    EntityManager em;

    public ObjetoEstadoBean() {
        super(ObjetoEstado.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public List<ObjetoEstado> findByIdObjetoEstado(final Long idObjetoEstado) {
        if (this.em != null && idObjetoEstado != null) {
            Query q = em.createNamedQuery("ObjetoEstado.findByIdObjetoEstado");
            q.setParameter("idObjetoEstado", idObjetoEstado);
            return q.getResultList();

        }
        return Collections.EMPTY_LIST;
    }

}
