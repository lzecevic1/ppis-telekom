import Ember from 'ember';

export default Ember.Controller.extend({
  actions: {
    selectType: function (value) {
      this.set('model.type', value);
    },
    selectPriority: function (value) {
        this.set('model.priority', value);
    },
  }
});
