import Ember from 'ember';
import BaseHttpService from './base-http-service';

export default BaseHttpService.extend({
    currentPackage: null,
    newPackage:null,

    createPackage(){
        let newPackage = Ember.Object.create({
            name: '',
            description: '',
            price: 0,
            status: 0
        });
        this.set('currentPackage',newPackage);
        return this.get('currentPackage');
    },

    getAllPackages() {
        return this.ajax('GET', '/packages');
      },
    
    addPackage(packageItem){
        return this.ajax('POST', '/packages', packageItem);
    },
    deactivatePackage(id) {
        return this.ajax('POST', `/packages/${id}/deactivate`);
      },
    

});
