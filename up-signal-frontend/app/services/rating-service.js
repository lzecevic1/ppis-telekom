import Ember from 'ember';
import BaseHttpService from './base-http-service';

export default BaseHttpService.extend({
    currentRating: null,
    newRating: null,
    
    createRating(){
        let newRating = Ember.Object.create({
            ratingType: '',
            rating: 0.0,
            description: '',
        });
        this.set('currentRating',newRating);
        return this.get('currentRating');
    },

    addRating(rating){
        return this.ajax('POST', '/ratings', rating);
    }
});
