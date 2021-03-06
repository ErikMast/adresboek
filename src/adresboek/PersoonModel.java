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

    private List<Persoon> personen;
    private Persoon geselecteerdPersoon;

    public PersoonModel(PersoonDao persoonDao) {
        this.persoonDao = persoonDao;
    }

    public Persoon getGeselecteerdPersoon() {
        return geselecteerdPersoon;
    }

    public List<Persoon> list() {
        if (hasChanged() || personen == null) {
            personen = persoonDao.list();
        }
        return personen;
    }

    public Persoon find(Long id) {
        return persoonDao.find(id);
    }

    public void save(Persoon persoon) {
        async(() -> {
            persoonDao.save(persoon);
            setChangedAndNotify();
        });
    }

    private void setChangedAndNotify() {
        setChanged();
        personen = null;
        notifyObservers();
    }

    public void delete(Persoon persoon) {
        async(() -> {
            persoonDao.delete(persoon);
            setChangedAndNotify();
        });
    }

    private void async(Runnable block) {
        new Thread(block).start();
    }

    public void refresh() {
        async(this::setChangedAndNotify);
    }

    public void selectPersoonByIndex(int index) {
        async(() -> {
            list();
            if (index >= 0 && index < personen.size()) {
                geselecteerdPersoon = personen.get(index);
                setChanged();
                notifyObservers();
            }
        });
    }
}
