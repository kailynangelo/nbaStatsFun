package persistence;

import entity.Team;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Team class DAO.
 */
public class TeamDao {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets a list of all teams.
     *
     * @return a list of teams
     */
    public List<Team> getAllTeams() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Team> query = builder.createQuery(Team.class);
        Root<Team> root = query.from(Team.class);
        List<Team> teams = session.createQuery(query).getResultList();
        session.close();

        logger.debug("List of teams: " + teams);

        return teams;
    }

    /**
     * Gets team by team name.
     *
     * @param teamname the teamname
     * @return the Team with given teamname
     */
    public List<Team> getByTeamName(String teamname) {

        logger.debug("Searching for: {}", teamname);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Team> query = builder.createQuery(Team.class);
        Root<Team> root = query.from(Team.class);
        Expression<String> propertyPath = root.get("teamName");
        query.where(builder.like(propertyPath, teamname));
        List<Team> team = session.createQuery(query).getResultList();
        session.close();
        return team;
    }

    /**
     * Insert team into database
     *
     * @param team the team to be inserted
     * @return number of rows affected (1 if success)
     */
    public int insert(Team team) {

        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(team);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Make updates to a given team
     *
     * @param team the team to update
     */
    public void saveOrUpdate(Team team) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(team);
        transaction.commit();
        session.close();
    }

    /**
     * Delete a team from the database
     *
     * @param team the team to delete
     */
    public void delete(Team team) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(team);
        transaction.commit();
        session.close();
    }
}
