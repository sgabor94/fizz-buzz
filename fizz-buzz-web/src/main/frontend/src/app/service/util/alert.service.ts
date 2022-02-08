import {Injectable} from '@angular/core';
import {NavigationStart, Router} from '@angular/router';
import {Observable, Subject} from 'rxjs';

export class Alert {
  type: AlertType;
  message: string;
}

export enum AlertType {
  Error
}

@Injectable()
export class AlertService {

  private subject = new Subject<Alert>();
  private keepAfterRouteChange = false;
  public hideAlerts = false;
  public hideSeconds = 2000;

  constructor(private router: Router) {
    // clear alert messages on route change unless 'keepAfterRouteChange' flag is true
    router.events.subscribe(event => {
      if (event instanceof NavigationStart) {
        if (this.keepAfterRouteChange) {
          // only keep for a single route change
          this.keepAfterRouteChange = false;
        } else {
          // clear alert messages
          this.clear();
        }
      }
    });
  }

  getAlert(): Observable<any> {
    return this.subject.asObservable();
  }

  error(message: string, keepAfterRouteChange = false) {
    this.alert(AlertType.Error, message, keepAfterRouteChange);
  }

  alert(type: AlertType, message: string, keepAfterRouteChange = false, hideAlerts = false, hideSeconds = 2000) {
    this.keepAfterRouteChange = keepAfterRouteChange;
    this.hideAlerts = hideAlerts;
    this.hideSeconds = hideSeconds;
    this.subject.next({type, message} as Alert);
  }

  clear() {
    // clear alerts
    // @ts-ignore
    this.subject.next();
  }

  // @ts-ignore
  handleError(error) {
    console.error('Error occurred', error);
    const errorCode = error.error.description;
    if (errorCode) {
      this.error(errorCode);
    } else {
      this.error('Error occurred');
    }
  }
}
