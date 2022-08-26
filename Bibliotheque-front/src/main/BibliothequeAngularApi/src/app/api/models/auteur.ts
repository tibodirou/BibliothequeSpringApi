/* tslint:disable */
/* eslint-disable */
import { Livre } from './livre';

/**
 * un auteur
 */
export interface Auteur {
  livres?: Array<Livre>;
  name?: string;
}
