import {Component, OnInit} from '@angular/core';
import {Alert, AlertService, AlertType} from '../../../service/util/alert.service';
import {fadeInAnimation} from '../../../util/animations';

@Component({
  selector: 'app-alert',
  templateUrl: 'alert.component.html',
  styleUrls: ['alert.component.scss'],
  animations: [fadeInAnimation]
})

export class AlertComponent implements OnInit {

  alerts: Alert[] = [];

  constructor(private alertService: AlertService) {
  }

  ngOnInit() {
    this.alertService.getAlert().subscribe((alert: Alert) => {
      if (!alert) {
        // clear alerts when an empty alert is received
        this.alerts = [];
        return;
      }
      // add alert to array
      this.alerts.push(alert);

      if (this.alertService.hideAlerts) {
        // remove alert after 3 seconds
        setTimeout(() => this.removeAlert(alert), 3000);
      }
    });
  }

  removeAlert(alert: Alert) {
    this.alerts = this.alerts.filter(x => x !== alert);
  }

  // noinspection JSMethodCanBeStatic
  // @ts-ignore
  cssClass(alert: Alert) {
    if (!alert) {
      return;
    }
    // return css class based on alert type
    if (alert.type === AlertType.Error) {
      return 'alert-danger';
    }
  }
}
