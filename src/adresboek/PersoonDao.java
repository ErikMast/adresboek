/*
Copyright 2016 Spelberg IT

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package adresboek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersoonDao implements Dao<Persoon> {

    private Connection connection;

    public PersoonDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Persoon> list() {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM persoon")) {
            List<Persoon> personen = new ArrayList<>();
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Long id = resultSet.getLong("ID");
                    String voornaam = resultSet.getString("VOORNAAM");
                    personen.add(new Persoon(id, voornaam));
                }
            }
            System.out.println("PersoonDao.list(): " + personen.size() + " gelezen uit de database");
            return personen;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Persoon find(Long id) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                "SELECT * FROM persoon WHERE ID = ?")) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String voornaam = resultSet.getString("VOORNAAM");
                    System.out.println("PersoonDao.find(" + id + ") gelezen uit de database");
                    return new Persoon(id, voornaam);
                }
            }
            System.out.println("PersoonDao.find(" + id + ") NIET GEVONDEN in de database");
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(Persoon persoon) {
        if (persoon.getId() == null) {
            try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                    "INSERT INTO persoon (VOORNAAM) VALUES (?)")) {
                preparedStatement.setString(1, persoon.getVoornaam());
                preparedStatement.execute();
                System.out.println("PersoonDao.save(null) NIEUW toegevoegd aan de database");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                    "UPDATE persoon SET VOORNAAM = ? WHERE ID = ?")) {
                preparedStatement.setString(1, persoon.getVoornaam());
                preparedStatement.setLong(2, persoon.getId());
                preparedStatement.execute();
                System.out.println("PersoonDao.save(" + persoon.getId() + ") bijgewerkt in de database");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Persoon persoon) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                "DELETE FROM persoon WHERE ID = ?")) {
            preparedStatement.setLong(1, persoon.getId());
            preparedStatement.execute();
            System.out.println("PersoonDao.delete(" + persoon.getId() + ") verwijderd uit de database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
