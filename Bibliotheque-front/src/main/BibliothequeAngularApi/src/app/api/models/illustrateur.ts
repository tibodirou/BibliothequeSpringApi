/* tslint:disable */
/* eslint-disable */
import { Livre } from './livre';

/**
 * Un illustrateur
 */
export interface Illustrateur {
  livres?: Array<Livre>;
  name?: string;
}
