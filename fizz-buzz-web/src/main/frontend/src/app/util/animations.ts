import {animate, state, style, transition, trigger} from '@angular/animations';

export const fadeInAnimation = [
  trigger('fadeIn', [
    state('in', style({opacity: 1})),
    transition(':enter', [
      style({opacity: 0}),
      animate(150)
    ]),
    transition(':leave',
      animate(150, style({opacity: 0})))
  ])
];

export const slideInOutAnimations = trigger('slideInOut', [
  transition(':enter', [
    style({transform: 'translateX(+100%)'}),
    animate('200ms ease-in', style({transform: 'translateX(0%)'}))
  ]),
  transition(':leave', [
    animate('200ms ease-in', style({transform: 'translateX(+100%)'}))
  ])
]);
