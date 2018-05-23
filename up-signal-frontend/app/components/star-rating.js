import EmberStarRatingComponent from 'ember-star-rating/components/star-rating';

export default EmberStarRatingComponent.extend({

    actions: {
    updateRating(ratingValue) {
        this.set('rating',ratingValue)
    },
}
});