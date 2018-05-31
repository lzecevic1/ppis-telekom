import Ember from 'ember';

function randomIntFromInterval(min,max)
{
    return Math.floor(Math.random()*(max-min+1)+min);
}

export default Ember.Controller.extend({
    activeContracts: randomIntFromInterval(500,1000),
    canceledContracts: randomIntFromInterval(20,50),
    renewedContracts: randomIntFromInterval(400,800),

    actions:{
        goBack() {
            this.set('activeContracts',randomIntFromInterval(500,1000));
            this.set('canceledContracts',randomIntFromInterval(20,50));
            this.set('renewedContracts',randomIntFromInterval(400,800));
            this.transitionToRoute('all-services');
        }
    }
});
