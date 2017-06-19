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

public class Persoon {

    private Long id;
    private String voornaam;

    public Persoon(Long id, String voornaam) {
        this.id = id;
        this.voornaam = voornaam;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persoon)) return false;

        Persoon persoon = (Persoon) o;

        if (id != null ? !id.equals(persoon.id) : persoon.id != null) return false;
        return voornaam != null ? voornaam.equals(persoon.voornaam) : persoon.voornaam == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (voornaam != null ? voornaam.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "id=" + id +
                ", voornaam='" + voornaam + '\'' +
                '}';
    }
}
