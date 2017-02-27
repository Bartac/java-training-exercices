package io.robusta.birthday.implementations;

import io.robusta.birthday.interfaces.IGeneration;
import io.robusta.birthday.interfaces.IPeopleCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas Zozol on 04/10/2016.
 */
public class Generation implements IGeneration{

    List<PeopleCollection> collections;

    public Generation(){

    }

    public Generation(int n, int collectionSize) {
        this.collections = createAllRandom(n, collectionSize);
    }

    @Override
    public PeopleCollection createRandom(int size) {
        
    	PeopleCollection peopleCollection = new PeopleCollection(size);
    	
    	return peopleCollection;
    }

    @Override
    public List<PeopleCollection> createAllRandom(int n, int size) {
        // call n times createRandom(size)
    	ArrayList<PeopleCollection> peopleCollection = new ArrayList<PeopleCollection>();
    	for (int i = 0; i < n; i++){
    		peopleCollection.add(createRandom(size));
    	}
        return peopleCollection;
    }

    @Override
    public List<PeopleCollection> getPeopleCollections() {
        return this.collections;
    }

    @Override
    public int getNumberOfCollectionsThatHasTwoPeopleWithSameBirthday() {
        int compt = 0;
    	
    	for (int i =0; i < this.collections.size(); i++){
    		if (collections.get(i).hasSame() == true){
    			compt++;
    		}
    	}
    	return compt;
    }

    @Override
    public boolean isLessThan50() {
        
    	float size = 0;
    	size = this.collections.size()/2;
    	if (this.getNumberOfCollectionsThatHasTwoPeopleWithSameBirthday() < size)
    		return true;
    	else return false;
    }
}
