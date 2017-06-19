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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Configuration {

    private final PersoonDao persoonDao;
    private final PersoonModel persoonModel;

    public Configuration(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/adresboek", "adresboek", "adresboek");
            persoonDao = new PersoonDao(connection);
            persoonModel = new PersoonModel(persoonDao);

            if (args.length > 0 && args[0].equals("--init")) {
                initDemoData(persoonDao);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public PersoonDao getPersoonDao() {
        return persoonDao;
    }

    public PersoonModel getPersoonModel() {
        return persoonModel;
    }

    private static void initDemoData(PersoonDao persoonDao) {
        List<Persoon> teVerwijderenPersonen = persoonDao.list();
        for (Persoon persoon : teVerwijderenPersonen) {
            persoonDao.delete(persoon);
        }

        persoonDao.save(new Persoon(null, "Hans"));
        persoonDao.save(new Persoon(null, "Grietje"));
        persoonDao.save(new Persoon(null, "Gemene Heks"));
        persoonDao.save(new Persoon(null, "Boze Stiefmoeder"));

        List<Persoon> personen = persoonDao.list();
        for (Persoon persoon : personen) {
            System.out.println("Toegevoegd: " + persoon);
        }

    }

}
