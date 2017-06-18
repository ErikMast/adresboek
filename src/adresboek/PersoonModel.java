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

import java.util.List;
import java.util.Observable;

public class PersoonModel extends Observable {

    private final PersoonDao persoonDao;

    public PersoonModel(PersoonDao persoonDao) {
        this.persoonDao = persoonDao;
    }

    public List<Persoon> list() {
        return this.persoonDao.list();
    }

    public Persoon find(Long id) {
        return this.persoonDao.find(id);
    }

    public void save(Persoon persoon) {
        async(() -> {
            this.persoonDao.save(persoon);
            this.setChanged();
            this.notifyObservers();
        });
    }

    public void delete(Persoon persoon) {
        async(() -> {
            this.persoonDao.delete(persoon);
            this.setChanged();
            this.notifyObservers();
        });
    }

    private void async(Runnable block) {
        new Thread(block).start();
    }

    public void refresh() {
        async(() -> {
            this.setChanged();
            this.notifyObservers();
        });
    }

}
