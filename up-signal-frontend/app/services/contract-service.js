import Ember from 'ember';
import BaseHttpService from './base-http-service';

export default BaseHttpService.extend({
	currentContract: null,
	newContract: null,

  createContract() {
    let newContract = Ember.Object.create({
      startDate: '',
      endDate: '',
      responsiblePerson: '',
      supplierId: ''
    });
    this.set('currentContract', newContract);
    return this.get('currentContract');
  },

   getAllContracts() {
    return this.ajax('GET', '/contracts');
  },

  getContract: function(id) {
  	return this.ajax('GET', `/contracts/${id}`)
  },

  addContract: function (contract) {
    return this.ajax('POST', '/contracts', contract);
  },

  deleteContract: function (id) {
    return this.ajax('DELETE', `/contracts/${id}`);
  }
});
